package com.transactional.util;

import java.io.Serializable;

public interface Valuable <V extends Serializable> {

    V getValue();

}