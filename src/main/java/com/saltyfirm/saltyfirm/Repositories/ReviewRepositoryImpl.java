package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Review;
import com.saltyfirm.saltyfirm.Repositories.DatabaseConnection.DbHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Martin | Nicholas
@Repository("ReviewRepositoryImpl")
public class ReviewRepositoryImpl implements ReviewRepository {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DbHandler dbHandler;

    /**
     * @author Martin
     * <p>
     *     When reviewId matches review_id the preparedstatment selects choosen cells from review, department and firm tabel.
     *     Review has firm_fk_id connectiong it to a firm id, firm has department_fk_id connecting it to a department id.
     *     Then it matches the int reviewId with review_id.
     * </p>
     *
     * @param reviewId Id to find review
     * @throws SQLException
     * @return review object if the database has a review_id matching reviewId, otherwise returning null
     */
    @Override
    public Review findReviewById(int reviewId) {
        log.info("Finding review by id");
        try {
            Connection connection = dbHandler.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT firm_name, department_name, review_id, post, salary, position, pension_scheme, benefits, management, work_environment, flexibility, employment_time " +
                                                                                   "FROM saltyfirm.review, saltyfirm.department, saltyfirm.firm " +
                                                                                   "WHERE firm_fk_id = firm_id AND department_fk_id = department_id AND review_id = ?;");

            preparedStatement.setInt(1, reviewId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                Review review = new Review();
                review.setReviewId(resultSet.getInt("review_id"));
                review.setDepartmentName(resultSet.getString("department_name"));
                review.setFirmName(resultSet.getString("firm_name"));
                review.setPost(resultSet.getString("post"));
                review.setSalary(resultSet.getInt("salary"));
                review.setPosition(resultSet.getString("position"));
                review.setPensionScheme(resultSet.getInt("pension_scheme"));
                review.setBenefits(resultSet.getInt("benefits"));
                review.setManagement(resultSet.getInt("management"));
                review.setWorkEnvironment(resultSet.getInt("work_environment"));
                review.setFlexibility(resultSet.getInt("flexibility"));
                review.setEmploymentTime(resultSet.getInt("employment_time"));
                return review;
            }
            connection.close();

        } catch (SQLException e) {
            log.warn("Found SQLException: ");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author Martin
     *<p>
     *      En metode til at sørge for at lægge et review det rette sted i databasen.
     *      Da input fra brugeren er et navn på en virksomhed og afdeling, kræves det at der først tjekket om
     *      virksomheden eksisterer, som sker i første den af metoden. Derefter følger en række if-statements,
     *      som der som udgangspunkt sørger for at tjekke efter virksomhed/afdeling, og opretter et nyt hvis det
     *      ikke findes - og ellers returneres ID'et for de to. Når man har begge ID'er, kan reviewet oprettes
     *      og forbindes til den rigtige afdeling og virksomhed gennem PK/FK.
     *</p>
     *
     * @param review  review object
     * @param userId  Id for a user
     * @throws SQLException
     * @return
     */
    @Override
    public int createReview(Review review, int userId) {
        log.info("Creating review");
        int departmentId = 0;
        int firmId = 0;
        try {
            Connection connection = dbHandler.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT firm_id FROM saltyfirm.firm WHERE firm_name = ?");
            preparedStatement.setString(1,review.getFirmName());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                firmId = resultSet.getInt("firm_id");
                preparedStatement = connection.prepareStatement("SELECT department_id FROM saltyfirm.department WHERE department_name = ?");
                preparedStatement.setString(1,review.getDepartmentName());
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    departmentId = resultSet.getInt("department_id");
                } else {
                    preparedStatement = connection.prepareStatement("INSERT INTO saltyfirm.department (department_name, firm_fk_id) VALUES (?,?)");
                    preparedStatement.setString(1, review.getDepartmentName());
                    preparedStatement.setInt(2, firmId);
                    preparedStatement.executeUpdate();
                    preparedStatement = connection.prepareStatement("SELECT department_id FROM saltyfirm.department WHERE department_name = ?");
                    preparedStatement.setString(1, review.getDepartmentName());
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        departmentId = resultSet.getInt("department_id");
                    }
                }
            } else {
                preparedStatement = connection.prepareStatement("INSERT INTO saltyfirm.firm (firm_name) VALUES (?)");
                preparedStatement.setString(1, review.getFirmName());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement("SELECT firm_id FROM saltyfirm.firm WHERE firm_name = ?");
                preparedStatement.setString(1,review.getFirmName());
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    firmId = resultSet.getInt("firm_id");
                    preparedStatement = connection.prepareStatement("INSERT INTO saltyfirm.department (department_name, firm_fk_id) VALUES (?,?)");
                    preparedStatement.setString(1, review.getDepartmentName());
                    preparedStatement.setInt(2,firmId);
                    preparedStatement.executeUpdate();
                    preparedStatement = connection.prepareStatement("SELECT department_id FROM saltyfirm.department, saltyfirm.firm WHERE department_name = ? AND firm_fk_id = ?;");
                    preparedStatement.setString(1,review.getDepartmentName());
                    preparedStatement.setInt(2,firmId);
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        departmentId = resultSet.getInt("department_id");
                    }
                }
            }
            resultSet.close();
            preparedStatement = connection.prepareStatement("INSERT INTO saltyfirm.review (post, salary, position, pension_scheme, benefits," +
                                                                 "management, work_environment, flexibility, employment_time, user_fk_id, department_fk_id) " +
                                                                 "VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, review.getPost());
            preparedStatement.setInt(2, review.getSalary());
            preparedStatement.setString(3, review.getPosition());
            preparedStatement.setDouble(4, review.getPensionScheme());
            preparedStatement.setDouble(5, review.getBenefits());
            preparedStatement.setDouble(6, review.getManagement());
            preparedStatement.setDouble(7, review.getWorkEnvironment());
            preparedStatement.setDouble(8, review.getFlexibility());
            preparedStatement.setInt(9, review.getEmploymentTime());
            preparedStatement.setInt(10, userId);
            preparedStatement.setInt(11, departmentId);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("UPDATE saltyfirm.department SET department_score = " +
                                                                "  (SELECT" +
                                                                "    (SELECT SUM(pension_scheme + benefits + management + work_environment + flexibility) / 5 AS total_score) /" +
                                                                "    (SELECT COUNT(review_id)) AS total_total_score" +
                                                                "    FROM saltyfirm.review WHERE department_fk_id = department_id) " +
                                                                "WHERE department_id = ?");
            preparedStatement.setInt(1, departmentId);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("UPDATE saltyfirm.firm SET overall_score = (SELECT AVG(department_score) FROM saltyfirm.department WHERE firm_fk_id = firm_id) WHERE firm_id = ?");
            preparedStatement.setInt(1, firmId);
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            log.warn("Found SQLException: ");
            e.printStackTrace();
        }

        return 0;
    }


    /**
     * @author Martin / Nicholas
     * Updates cells for a review where review_id matches the reviewId from review object
     *
     * @param review review object
     * @throws SQLException
     * @return 0
     */
    @Override
    public int editReview(Review review) {
        log.info("Editing review ");
        int departmentId = 0;
        try {
            Connection connection = dbHandler.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE saltyfirm.review SET post = ?, salary = ?, `position` = ?, pension_scheme = ?, benefits = ?, " +
                                                                                   "management = ?, work_environment = ?, flexibility = ?, employment_time = ? WHERE review_id = ?");

            preparedStatement.setString(1, review.getPost());
            preparedStatement.setInt(2, review.getSalary());
            preparedStatement.setString(3, review.getPosition());
            preparedStatement.setDouble(4, review.getPensionScheme());
            preparedStatement.setDouble(5, review.getBenefits());
            preparedStatement.setDouble(6, review.getManagement());
            preparedStatement.setDouble(7, review.getWorkEnvironment());
            preparedStatement.setDouble(8, review.getFlexibility());
            preparedStatement.setInt(9, review.getEmploymentTime());
            preparedStatement.setInt(10, review.getReviewId());

            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("SELECT department_fk_id FROM saltyfirm.review WHERE review_id = ?");
            preparedStatement.setInt(1, review.getReviewId());
            ResultSet resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                departmentId = resultset.getInt(1);
            }

            preparedStatement = connection.prepareStatement("UPDATE saltyfirm.department \n" +
                                                                "SET department_score = \n" +
                                                                "  (SELECT\n" +
                                                                "    (SELECT SUM(pension_scheme + benefits + management + work_environment + flexibility) / 5 AS total_score) /\n" +
                                                                "    (SELECT COUNT(benefits)) AS total_total_score\n" +
                                                                "    FROM saltyfirm.review\n" +
                                                                "    WHERE department_fk_id = department_id) \n" +
                                                                "WHERE department_id = ?;");

            preparedStatement.setInt(1, departmentId);
            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            log.warn("Found SQLException: ");
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * @author Martin / Nicholas
     * <p>
     *
     * </p>
     *
     * @param reviewId id for review
     * @return 0
     */
    @Override
    public int deleteReview(int reviewId) {
        log.info("Deleting review");
        int departmentId = 0;
        try {
            Connection connection = dbHandler.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT department_id FROM saltyfirm.department, saltyfirm.review WHERE department_id = department_fk_id AND review_id = ?");
            preparedStatement.setInt(1, reviewId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                departmentId = resultSet.getInt(1);
            }

            preparedStatement = connection.prepareStatement("DELETE FROM saltyfirm.review WHERE review_id = ?");
            preparedStatement.setInt(1, reviewId);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("UPDATE saltyfirm.department \n" +
                                                                "SET department_score = \n" +
                                                                "  (SELECT\n" +
                                                                "    (SELECT SUM(pension_scheme + benefits + management + work_environment + flexibility) / 5 AS total_score) /\n" +
                                                                "    (SELECT COUNT(review_id)) AS total_total_score\n" +
                                                                "    FROM saltyfirm.review\n" +
                                                                "    WHERE department_fk_id = department_id) \n" +
                                                                "WHERE department_id = ?;");

            preparedStatement.setInt(1, departmentId);
            preparedStatement.executeUpdate();
           connection.close();

        } catch (SQLException e) {
            log.warn("Found SQLException: ");
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * @author Martin
     *<p>
     *     Selects choosen parameters from review, department and firm tabel where user_fk_id matches userid
     *     Review has department_fk_id that connects the review to a departmentId
     *     Department has firm_fk_id linking ti to the firm
     *</p>
     * @param userId int id for user
     *
     * @return userReviews list if a user have created a review for a firm and department, otherwise it returns null
     */
    public List<Review> fetchUserReview(int userId) {
        log.info("Fetching users reviews");
        List<Review> userReviews = new ArrayList<>();

        try {
            Connection connection = dbHandler.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT firm_name, department_name, review_id, post, salary, position, pension_scheme, benefits, management, work_environment, flexibility, employment_time " +
                    "FROM saltyfirm.review, saltyfirm.department, saltyfirm.firm "+
                    "WHERE user_fk_id = ? AND department_fk_id = department_id AND firm_fk_id = firm_id");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Review review = new Review();
                review.setFirmName(resultSet.getString("firm_name"));
                review.setDepartmentName(resultSet.getString("department_name"));
                review.setReviewId(resultSet.getInt("review_id"));
                review.setBenefits(resultSet.getInt("benefits"));
                review.setSalary(resultSet.getInt("salary"));
                review.setEmploymentTime(resultSet.getInt("employment_time"));
                review.setFlexibility(resultSet.getInt("flexibility"));
                review.setManagement(resultSet.getInt("management"));
                review.setPensionScheme(resultSet.getInt("pension_scheme"));
                review.setWorkEnvironment(resultSet.getInt("work_environment"));
                review.setPosition(resultSet.getString("position"));
                review.setPost(resultSet.getString("post"));
                userReviews.add(review);
            }
            connection.close();

            return userReviews;
        } catch (SQLException e) {
            log.warn("Found SQLException: ");
            e.printStackTrace();
        }
        return null;
    }


}
