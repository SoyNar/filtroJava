package com.riwi.Persistence.IModel;

import com.riwi.Entity.Student;
import com.riwi.Persistence.ICrud.ICreate;
import com.riwi.Persistence.ICrud.IDelete;
import com.riwi.Persistence.ICrud.IRead;
import com.riwi.Persistence.ICrud.IUpdate;

public interface IStudent extends ICreate<Student>,
        IRead<Student>, IDelete<Integer>, IUpdate<Student> {
}
