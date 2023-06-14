package com.andgigachad.retrofit_mvvm_hilt_project.network.mappers

import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.CategoriesDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.util.DomainMapper
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.CategoriesNetwork

class CategoriesMapper : DomainMapper<CategoriesNetwork, CategoriesDomain>{
    override fun mapToDomainModel(model: CategoriesNetwork): CategoriesDomain {
        return CategoriesDomain(
            categories = model.categories
        )
    }

    override fun mapToModel(domainModel: CategoriesDomain): CategoriesNetwork {
        return CategoriesNetwork(
            categories = domainModel.categories
        )
    }
}