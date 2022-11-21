package neu.csye7374.src.Factory_Pattern;

import neu.csye7374.src.Builder.*;

public abstract class AbstractFactory<T> {
	public abstract T getObject(BuilderAPI<T> builder);
}
