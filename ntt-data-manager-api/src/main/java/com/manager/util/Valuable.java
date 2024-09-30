package com.manager.util;

import java.io.Serializable;

public interface Valuable <V extends Serializable> {

    V getValue();

}