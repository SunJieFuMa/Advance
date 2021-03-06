package com.quduquxie.model;

import java.io.Serializable;

/**
 * Created on 17/1/17.
 * Created by crazylei.
 */

public class Category implements Serializable {
    public String label;
    public int item_type;
    public boolean check;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Category)) {
            return false;
        } else {
            Category category = (Category) o;
            return category.label.equals(this.label) && category.item_type == this.item_type;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        return result;
    }
}
