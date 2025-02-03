package com.karamanmert.bpn_case.prob7_payment_processing.new1;

/**
 * @author karamanmert
 */
// generic bir yapı olsun diye yaptım ama ihtiyaca göre de değişebilir.
public interface LogService<T, K> {

    void log(T t, K k);
}
