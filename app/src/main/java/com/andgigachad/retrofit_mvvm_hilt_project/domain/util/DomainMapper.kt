package com.andgigachad.retrofit_mvvm_hilt_project.domain.util

import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.CategoriesDomain
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.CategoriesNetwork

interface DomainMapper<Model, DomainModel> {

    fun mapToDomainModel(model: CategoriesNetwork): DomainModel

    fun mapToModel(domainModel: DomainModel) : Model
}