package de.tu_bs.ccc.contracting.core.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class AbstractObjectWriter<T> {
	protected T object;

	public void setObject(T object) {
		this.object = object;
	}

	public T getObject() {
		return object;
	}

	public void writeToFile(File file) {
		try (FileOutputStream output = new FileOutputStream(file)) {
			output.write(writeToString().getBytes(Charset.availableCharsets().get("UTF-8")));
			output.flush();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	protected abstract String writeToString();

}