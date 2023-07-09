package com.andgigachad.retrofit_mvvm_hilt_project.network.mappers

import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.CategoriesDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.util.Mapper
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.CategoriesNetwork

class CategoriesMapper : Mapper<CategoriesNetwork, CategoriesDomain> {
    override fun mapToDomainModel(networkModel: CategoriesNetwork): CategoriesDomain {
        return CategoriesDomain(
            categories = networkModel.categories
        )
    }

    override fun mapToNetworkModel(domainModel: CategoriesDomain): CategoriesNetwork {
        return CategoriesNetwork(
            categories = domainModel.categories
        )
    }
}