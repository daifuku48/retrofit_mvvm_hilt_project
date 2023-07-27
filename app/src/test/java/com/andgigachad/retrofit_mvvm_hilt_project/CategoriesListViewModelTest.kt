package com.andgigachad.retrofit_mvvm_hilt_project

import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import com.andgigachad.retrofit_mvvm_hilt_project.app.App
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.ErrorResult
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.SuccessResult
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllCategoriesMealUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.Category
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.base.LiveResult
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.base.MutableLiveResult
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.CategoriesListViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.net.UnknownHostException
import javax.inject.Inject


@Suppress("UNCHECKED_CAST")
@ExperimentalCoroutinesApi
class CategoriesListViewModelTest {

    @Mock
    lateinit var getAllCategoriesMealUseCase: GetAllCategoriesMealUseCase

    private lateinit var viewModel: CategoriesListViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(getAllCategoriesMealUseCase)
        viewModel = CategoriesListViewModel(getAllCategoriesMealUseCase, SavedStateHandle())
    }


    @Test
    fun `test fetchData success`() {
        runBlocking {
            val listCategories = listOf(
                Category(
                    idCategory = "1",
                    strCategory = "Beef",
                    strCategoryDescription = "Beef is meat",
                    strCategoryThumb = "image of beef"
                )
            )
            viewModel.categoriesList.observeForever(mock())

        }
    }

    @Test
    fun `test fetchData failure`() {

    }

    // Helper function to create a mock of an Observer
    private fun <T> mock(): Observer<T> = Mockito.mock(Observer::class.java) as Observer<T>
}