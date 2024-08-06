package com.riwi.Persistence.IModel;

import com.riwi.Entity.Inscription;
import com.riwi.Persistence.ICrud.ICreate;
import com.riwi.Persistence.ICrud.IDelete;
import com.riwi.Persistence.ICrud.IRead;
import com.riwi.Persistence.ICrud.IUpdate;

public interface IInscription extends
        ICreate<Inscription>,
        IRead<Inscription>,
        IUpdate<Inscription>,
        IDelete<Integer> {
}
