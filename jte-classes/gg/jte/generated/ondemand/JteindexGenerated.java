package gg.jte.generated.ondemand;
import org.example.hexlet.Course;
import org.example.hexlet.Routes;
import java.util.List;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,16,16,16,16,16,16,16,16,16,16,17,17,17,18,18,18,18,18,18,18,18,18,19,19,19,19,19,19,19,19,19,22,22,24,24,25,25,27,27,27,29,29,32,32,33,33,33,33,33,33,33,34,34,38,38,38,3,4,5,6,6,6,6};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String term, List<Course> all, boolean isVisited, String flash) {
		jteOutput.writeContent("\n\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"utf-8\"/>\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n</head>\n<body>\n<a");
		var __jte_html_attribute_0 = Routes.addCoursesPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("> Add course</a>\n<h1>Courses: ");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(all.size());
		jteOutput.writeContent("</h1>\n<form");
		var __jte_html_attribute_1 = Routes.coursesPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" action=\"");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("form", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" method=\"get\">\n    <input type=\"search\" required name=\"term\"");
		var __jte_html_attribute_2 = term;
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_2);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">\n    <input type=\"submit\" value=\"Искать\">\n</form>\n");
		if (!isVisited) {
			jteOutput.writeContent("\n    This message appears only when you visited site for the first time.\n");
		}
		jteOutput.writeContent("\n");
		if (flash != null) {
			jteOutput.writeContent("\n    <div class=\"alert alert-success\" role=\"alert\">\n        ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(flash);
			jteOutput.writeContent("\n    </div>\n");
		}
		jteOutput.writeContent("\n\n<a>\n    ");
		for (Course course: all) {
			jteOutput.writeContent("\n        <li><a href=\"/courses/");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(course.getId());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\">");
			jteOutput.setContext("a", null);
			jteOutput.writeUserContent(course.getName());
			jteOutput.writeContent("</a></li>\n    ");
		}
		jteOutput.writeContent("\n\n</a>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String term = (String)params.get("term");
		List<Course> all = (List<Course>)params.get("all");
		boolean isVisited = (boolean)params.get("isVisited");
		String flash = (String)params.get("flash");
		render(jteOutput, jteHtmlInterceptor, term, all, isVisited, flash);
	}
}
