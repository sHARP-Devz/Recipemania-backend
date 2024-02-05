package com.SharpDevs.Recipe.Mania.domain.Mappers;

import com.SharpDevs.Recipe.Mania.domain.DTO.RecipeDto;
import com.SharpDevs.Recipe.Mania.domain.Entity.RecipeEntity;

import java.util.Iterator;

public interface Mapper<A,B>{
    B mapTo(A a);

    A mapFrom(B b);

    Iterable<B> mapListTo(Iterable<A> a);




}
