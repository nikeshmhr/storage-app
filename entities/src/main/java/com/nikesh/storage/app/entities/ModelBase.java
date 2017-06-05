package com.nikesh.storage.app.entities;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * @author Nikesh Maharjan
 *         nikeshmhr@gmail.com
 */
public class ModelBase implements Serializable {

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
