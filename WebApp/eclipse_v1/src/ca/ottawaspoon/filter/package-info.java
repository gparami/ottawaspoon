/**
 * This package contains two filters <code>JDBCFilter</code> and <code>CookieFilter</code>.
 * 
 * The <code>JDBCFilter</code> will check the request to ensure that it only opens JDBC connection for the necessary request,
 * example: for Servlet, avoid opening JDBC connection to common requests like image, css, js, html.
 * 
 * The <code>CookieFilter</code> will remember information in previous user login (for example the day before)
 * and will check the Cookie information stored by the browser and login automatically.
 * 
 */
/**
 * @author parami
 *
 */
package ca.ottawaspoon.filter;