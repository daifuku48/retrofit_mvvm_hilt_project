package com.andgigachad.retrofit_mvvm_hilt_project.domain.util

interface MealsDomainMapper<NetworkModel, DomainModel> {
    fun mapToDomainModel(networkModel: NetworkModel) : DomainModel
    fun mapToNetworkModel(domainModel: DomainModel) : NetworkModel
}