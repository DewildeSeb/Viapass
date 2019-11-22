package be.iso.viapass.db;

import be.iso.viapass.util.ConstantsISO;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * we will get the information to create a connection to postgrsql DB viapass
 * we could open and close the connection here
 */
@Component
@NoArgsConstructor
public class ConnectionDB {

        private final static Logger LOG = LogManager.getLogger(ConnectionDB.class);

        @Value("${viapassdb.connectionstring}")
        public String connectionString;

        @Value("${viapassdb.connectionuser}")
        private String postgresUser;

        @Value("${viapassdb.connectionpassword}")
        private String postgresPassword;

        private Charset charset;

        private static Connection conn = null;

        private Connection getConnection() throws SQLException, ClassNotFoundException {
                try {
                        LOG.info("Opening viapassDB PostgreSQL connection.");
                        charset = Charset.forName("UTF-8");
                        Class.forName("org.postgresql.Driver");
                        Connection conn = DriverManager.getConnection(connectionString, postgresUser, postgresPassword);
                        conn.setAutoCommit(false);
                        return conn;
                } catch (ClassNotFoundException cNFE) {
                        LOG.error("Fatal error, cannot load PostgreSQL driver, installation issue? " + cNFE.getMessage());
                        throw cNFE;
                }
        }

        public Connection start() throws ClassNotFoundException, SQLException {
                if (conn == null) {
                        conn = getConnection();
                        LOG.info("New " + ConstantsISO.DB_NAME + " DB connection.");
                }
                return conn;
        }

        public void stop() {
                if (conn != null) {
                        try {
                                conn.close();
                        } catch (SQLException e) {
                                e.printStackTrace();
                                LOG.error("Error while closing DB connection: " + e.getMessage());
                        }
                        conn = null;
                }
        }
}
