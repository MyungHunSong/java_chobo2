package java_chobo2.ch14;

@FunctionalInterface
public interface TryFunction<T,U,V,R> {
	R apply(T t, U u,V v);
}
