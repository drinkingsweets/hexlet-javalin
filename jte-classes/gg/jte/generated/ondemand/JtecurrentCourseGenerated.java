package gg.jte.generated.ondemand;
import org.example.hexlet.Course;
public final class JtecurrentCourseGenerated {
	public static final String JTE_NAME = "currentCourse.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,7,7,7,7,9,9,9,12,12,12,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Course course) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html>\n<body>\n<meta charset=\"utf-8\">\n<h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(course.getName());
		jteOutput.writeContent("</h1>\n<p>\n    ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(course.getDescription());
		jteOutput.writeContent("\n</p>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Course course = (Course)params.get("course");
		render(jteOutput, jteHtmlInterceptor, course);
	}
}
