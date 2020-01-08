package actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 官方实例  20160822 
 * @author Wei
 *
 */
public class TextResult extends ActionSupport {
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public String execute() throws Exception {
		inputStream = new ByteArrayInputStream(
				"Hello World! This is a text string response from a Struts 2 Action."
						.getBytes("UTF-8"));
		return SUCCESS;
	}
}