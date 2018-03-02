import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		/* IMPLEMENT THIS METHOD! */
		Stack<HtmlTag> tagStack = new Stack<HtmlTag>();
		
		while (tags.peek() != null) {
			HtmlTag currentTag = tags.peek();
			if (currentTag.isOpenTag()) {
				tagStack.push(currentTag);
				tags.remove();
			}
			else if (currentTag.isSelfClosing() ) {
				tags.remove();
			}
			else {
				if (tagStack.empty()) {
					return null;
				}
				else if (currentTag.matches(tagStack.peek())) {
					tagStack.pop();
					tags.remove();
				}
				else {
					// return stack with opening tags
					return tagStack;
				}
			}
		}
		// return empty stack
		return tagStack; 
	}
	

}

