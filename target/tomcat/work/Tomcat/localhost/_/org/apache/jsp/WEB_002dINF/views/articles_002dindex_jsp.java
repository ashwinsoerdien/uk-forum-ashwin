/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-11-17 08:05:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class articles_002dindex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/views/common/navigation.jspf", Long.valueOf(1510905935000L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jspf", Long.valueOf(1510905821000L));
    _jspx_dependants.put("/WEB-INF/views/common/header.jspf", Long.valueOf(1510905838000L));
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<link href=\"webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\"\n");
      out.write("\trel=\"stylesheet\">\n");
      out.write("<title>UK Forum - ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"container\">");
      out.write('\n');
      out.write("<nav class=\"navbar navbar-toggleable-md navbar-light bg-faded\">  \n");
      out.write("  <a class=\"navbar-brand\" href=\"#\">Navbar</a>\n");
      out.write("\n");
      out.write("  <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("    <ul class=\"navbar-nav mr-auto\">\n");
      out.write("      <li class=\"nav-item active\">\n");
      out.write("        <a class=\"nav-link\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link\" href=\"#\">Link</a>\n");
      out.write("      </li>\n");
      out.write("    </ul>\n");
      out.write("    <form class=\"form-inline my-2 my-lg-0\">\n");
      out.write("      <input class=\"form-control mr-sm-2\" type=\"text\" placeholder=\"Search\">\n");
      out.write("      <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\n");
      out.write("    </form>\n");
      out.write("  </div>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("<div class=\"jumbotron\">\n");
      out.write("\t<h1 class=\"display-3\">Welcome to the UK Forum</h1>\n");
      out.write("\t<p class=\"lead\">\n");
      out.write("\t\tPost your own articles now! <a href=\"/#\">Sign Up</a>\n");
      out.write("\t</p>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<script src=\"webjars/jquery/1.11.1/jquery.min.js\"></script>\n");
      out.write("<script src=\"webjars/bootstrap/4.0.0-beta.2/js/bootstrap.min.js\"></script>\n");
      out.write("</body>\n");
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
