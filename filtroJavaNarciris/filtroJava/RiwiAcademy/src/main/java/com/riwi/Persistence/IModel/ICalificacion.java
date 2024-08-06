package com.riwi.Persistence.IModel;

import com.riwi.Entity.Calificacion;
import com.riwi.Persistence.ICrud.ICreate;
import com.riwi.Persistence.ICrud.IDelete;
import com.riwi.Persistence.ICrud.IRead;
import com.riwi.Persistence.ICrud.IUpdate;

public interface ICalificacion extends
        ICreate<Calificacion>,
        IRead<Calificacion>,
        IUpdate<Calificacion>,
        IDelete<Integer> {
}
