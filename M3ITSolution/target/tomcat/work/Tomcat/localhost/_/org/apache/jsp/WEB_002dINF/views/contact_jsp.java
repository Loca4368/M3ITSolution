/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-07-18 02:08:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contact_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/footer.jsp", Long.valueOf(1498629721308L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link href=\"webjars/bootstrap/3.3.6/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<title>Contact Us</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- Header -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, true);
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<!-- Body -->\r\n");
      out.write("<div class =container>\r\n");
      out.write("<div class = \"page-header\">\r\n");
      out.write("<h4>Contact</h4>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<!-- Footer -->\r\n");
      out.write("<link href=\"https://fortawesome.github.io/Font-Awesome/assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("@import url(https://fonts.googleapis.com/css?family=Open+Sans:400,700,300);\r\n");
      out.write("footer { background-color:#0c1a1e; min-height:350px; font-family: 'Open Sans', sans-serif; }\r\n");
      out.write(".footerleft { margin-top:50px; padding:0 36px; }\r\n");
      out.write(".logofooter { margin-bottom:10px; font-size:25px; color:#fff; font-weight:700;}\r\n");
      out.write("\r\n");
      out.write(".footerleft p { color:#fff; font-size:12px !important; font-family: 'Open Sans', sans-serif; margin-bottom:15px;}\r\n");
      out.write(".footerleft p i { width:20px; color:#999;}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".paddingtop-bottom {  margin-top:50px;}\r\n");
      out.write(".footer-ul { list-style-type:none;  padding-left:0px; margin-left:2px;}\r\n");
      out.write(".footer-ul li { line-height:29px; font-size:12px;}\r\n");
      out.write(".footer-ul li a { color:#a0a3a4; transition: color 0.2s linear 0s, background 0.2s linear 0s; }\r\n");
      out.write(".footer-ul i { margin-right:10px;}\r\n");
      out.write(".footer-ul li a:hover {transition: color 0.2s linear 0s, background 0.2s linear 0s; color:#ff670f; }\r\n");
      out.write("\r\n");
      out.write(".social:hover {\r\n");
      out.write("     -webkit-transform: scale(1.1);\r\n");
      out.write("     -moz-transform: scale(1.1);\r\n");
      out.write("     -o-transform: scale(1.1);\r\n");
      out.write(" }\r\n");
      out.write(" \r\n");
      out.write(" .icon-ul { list-style-type:none !important; margin:0px; padding:0px;}\r\n");
      out.write(" .icon-ul li { line-height:75px; width:100%; float:left;}\r\n");
      out.write(" .icon { float:left; margin-right:5px;}\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" .copyright { min-height:40px; background-color:#000000;}\r\n");
      out.write(" .copyright p { text-align:left; color:#FFF; padding:10px 0; margin-bottom:0px;}\r\n");
      out.write(" .heading7 { font-size:21px; font-weight:700; color:#d9d6d6; margin-bottom:22px;}\r\n");
      out.write(" .post p { font-size:12px; color:#FFF; line-height:20px;}\r\n");
      out.write(" .post p span { display:block; color:#8f8f8f;}\r\n");
      out.write(" .bottom_ul { list-style-type:none; float:right; margin-bottom:0px;}\r\n");
      out.write(" .bottom_ul li { float:left; line-height:40px;}\r\n");
      out.write(" .bottom_ul li:after { content:\"/\"; color:#FFF; margin-right:8px; margin-left:8px;}\r\n");
      out.write(" .bottom_ul li a { color:#FFF;  font-size:12px;}\r\n");
      out.write("</style>\r\n");
      out.write("<!--footer start from here-->\r\n");
      out.write("<footer>\r\n");
      out.write("  <div class=\"container\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("      <div class=\"col-md-4 col-sm-6 footerleft \">\r\n");
      out.write("        <div class=\"logofooter\"> M3TISolution(Logo)</div>\r\n");
      out.write("        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley.</p>\r\n");
      out.write("        <p><i class=\"fa fa-map-pin\"></i>183 Walker Street, North Sydney, NSW2060</p>\r\n");
      out.write("        <p><i class=\"fa fa-phone\"></i> Phone (Australia) : +61 405 373 077</p>\r\n");
      out.write("        <p><i class=\"fa fa-envelope\"></i> E-mail : qiuming4368@gmail.com</p>\r\n");
      out.write("        \r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"col-md-2 col-sm-6 paddingtop-bottom\">\r\n");
      out.write("        <h6 class=\"heading7\">GENERAL LINKS</h6>\r\n");
      out.write("        <ul class=\"footer-ul\">\r\n");
      out.write("          <li><a href=\"#\"> Career</a></li>\r\n");
      out.write("          <li><a href=\"#\"> Privacy Policy</a></li>\r\n");
      out.write("          <li><a href=\"#\"> Terms & Conditions</a></li>\r\n");
      out.write("          <li><a href=\"#\"> Client Gateway</a></li>\r\n");
      out.write("          <li><a href=\"#\"> Ranking</a></li>\r\n");
      out.write("          <li><a href=\"#\"> Case Studies</a></li>\r\n");
      out.write("          <li><a href=\"#\"> Frequently Ask Questions</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"col-md-3 col-sm-6 paddingtop-bottom\">\r\n");
      out.write("        <h6 class=\"heading7\">LATEST POST</h6>\r\n");
      out.write("        <div class=\"post\">\r\n");
      out.write("          <p>facebook crack the movie advertisment code:what it means for you <span>August 3,2015</span></p>\r\n");
      out.write("          <p>facebook crack the movie advertisment code:what it means for you <span>August 3,2015</span></p>\r\n");
      out.write("          <p>facebook crack the movie advertisment code:what it means for you <span>August 3,2015</span></p>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"col-md-3 col-sm-6 paddingtop-bottom\">\r\n");
      out.write("        <div class=\"fb-page\" data-href=\"https://www.facebook.com/facebook\" data-tabs=\"timeline\" data-height=\"300\" data-small-header=\"false\" style=\"margin-bottom:15px;\" data-adapt-container-width=\"true\" data-hide-cover=\"false\" data-show-facepile=\"true\">\r\n");
      out.write("          <div class=\"fb-xfbml-parse-ignore\">\r\n");
      out.write("            <blockquote cite=\"https://www.facebook.com/facebook\"><a href=\"https://www.facebook.com/facebook\">Facebook</a></blockquote>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</footer>\r\n");
      out.write("<!--footer start from here-->\r\n");
      out.write("<div class=\"copyright\">\r\n");
      out.write("  <div class=\"container\">\r\n");
      out.write("    <div class=\"col-md-6\">\r\n");
      out.write("      <p>© 2017 - All Rights with M3ITSolution.com</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"col-md-6\">\r\n");
      out.write("      <ul class=\"bottom_ul\">\r\n");
      out.write("        <li><a href=\"#\">M3ITSolution.com</a></li>\r\n");
      out.write("        <li><a href=\"#\">About us</a></li>\r\n");
      out.write("        <li><a href=\"#\">News</a></li>\r\n");
      out.write("        <!--  <li><a href=\"#\">Faq's</a></li>-->\r\n");
      out.write("        <li><a href=\"#\">Contact us</a></li>\r\n");
      out.write("        <li><a href=\"#\">Site Map</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("<script src=\"webjars/jquery/1.9.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"webjars/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
