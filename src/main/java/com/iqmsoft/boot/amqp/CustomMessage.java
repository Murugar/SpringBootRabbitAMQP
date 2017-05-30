package com.iqmsoft.boot.amqp;

import java.io.Serializable;

public class CustomMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String text;
	private int priority;
	private boolean secret;

	public CustomMessage() {
	}

	public CustomMessage(String text, int priority, boolean secret) {
		this.text = text;
		this.priority = priority;
		this.secret = secret;
	}

	public String getText() {
		return text;
	}

	public int getPriority() {
		return priority;
	}

	public boolean isSecret() {
		return secret;
	}

	@Override
	public String toString() {
		return "CustomMessage{" + "text='" + text + '\'' + ", priority=" + priority + ", secret=" + secret + '}';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + priority;
		result = prime * result + (secret ? 1231 : 1237);
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomMessage other = (CustomMessage) obj;
		if (priority != other.priority)
			return false;
		if (secret != other.secret)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

}
