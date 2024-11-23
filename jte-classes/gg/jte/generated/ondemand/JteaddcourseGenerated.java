package gg.jte.generated.ondemand;
import org.example.hexlet.CoursesPageBuild;
import org.example.hexlet.Routes;
import org.example.hexlet.Routes;
public final class JteaddcourseGenerated {
	public static final String JTE_NAME = "addcourse.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,14,14,14,15,15,16,16,17,17,17,18,18,19,19,20,20,21,21,21,21,21,21,21,21,21,23,23,23,23,23,23,23,23,23,27,27,27,27,27,27,27,27,27,34,34,34,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPageBuild pageBuild) {
		jteOutput.writeContent("\n\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"utf-8\" />\n    <title>Add Course</title>\n</head>\n<body>\n<h1>Add Course</h1>\n");
		if (pageBuild != null && pageBuild.getErrors() != null) {
			jteOutput.writeContent("\n    ");
			for (var validator: pageBuild.getErrors().values()) {
				jteOutput.writeContent("\n        ");
				for (var error : validator) {
					jteOutput.writeContent("\n                  <li>");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(error.getMessage());
					jteOutput.writeContent("</li>\n              ");
				}
				jteOutput.writeContent("\n    ");
			}
			jteOutput.writeContent("\n");
		}
		jteOutput.writeContent("\n<form");
		var __jte_html_attribute_0 = Routes.addCoursesPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" action=\"");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("form", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" method=\"post\">\n    <label for=\"courseName\">Название курса:</label>\n    <input type=\"text\" id=\"courseName\" name=\"courseName\"");
		var __jte_html_attribute_1 = pageBuild != null ? pageBuild.getName() : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required />\n    <br />\n\n    <label for=\"courseDes\">Описание курса:</label>\n    <textarea id=\"courseDes\" name=\"courseDes\"");
		var __jte_html_attribute_2 = pageBuild != null ? pageBuild.getDescription() : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("textarea", "value");
			jteOutput.writeUserContent(__jte_html_attribute_2);
			jteOutput.setContext("textarea", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required></textarea>\n    <br />\n\n    <button type=\"submit\">Добавить курс</button>\n</form>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPageBuild pageBuild = (CoursesPageBuild)params.get("pageBuild");
		render(jteOutput, jteHtmlInterceptor, pageBuild);
	}
}
