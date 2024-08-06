package com.riwi.Persistence.IModel;

import com.riwi.Entity.Course;
import com.riwi.Persistence.ICrud.ICreate;
import com.riwi.Persistence.ICrud.IDelete;
import com.riwi.Persistence.ICrud.IRead;
import com.riwi.Persistence.ICrud.IUpdate;

import javax.swing.text.html.parser.Entity;

public interface ICourses extends
        ICreate<Course>,
        IRead<Course>,
        IUpdate<Course>,
        IDelete<Integer> {
}
