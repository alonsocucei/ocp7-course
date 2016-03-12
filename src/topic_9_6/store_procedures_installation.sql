/**
 * Author:  alonsocucei
 * Created: Mar 11, 2016
 */

/**
 * Replace the URL for the current jar path
 * APP.JDBC_CERT is the name that your jar will have in the DB
 * To execute this file, first connect through Services tab, then just select
 * the desired statement and click on Run Statement button.
 */

CALL sqlj.install_jar('D:\Personal Projects\OCP 7 Java Course\build\classes\ProductsProcedure.jar', 'APP.JDBC_CERT', 0)
CALL sqlj.replace_jar('D:\Personal Projects\OCP 7 Java Course\build\classes\ProductsProcedure.jar', 'APP.JDBC_CERT')
CALL syscs_util.syscs_set_database_property('derby.database.classpath', 'APP.JDBC_CERT')