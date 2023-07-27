package com.andgigachad.retrofit_mvvm_hilt_project

import com.andgigachad.retrofit_mvvm_hilt_project.data.repository.FavoriteMealRepositoryImpl
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.CategoriesDomain
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases.GetAllCategoriesMealUseCase
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.Category
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
class GetAllCategoriesMealUseCaseTest {

    @Mock
    lateinit var favoriteMealRepository: FavoriteMealRepositoryImpl
    private lateinit var getAllCategoriesMealUseCase: GetAllCategoriesMealUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getAllCategoriesMealUseCase = GetAllCategoriesMealUseCase(favoriteMealRepository)
    }


    @Test
    fun `test execute success`() = runBlockingTest {
        // Arrange
        val mockCategoriesDomain = CategoriesDomain(
            listOf(
                Category("1", "Category 1", "thumbnail1", "Description 1"),
                Category("2", "Category 2", "thumbnail2", "Description 2")
            )
        )
        `when`(favoriteMealRepository.getAllCategories()).thenReturn(mockCategoriesDomain)

        // Act
        val result = getAllCategoriesMealUseCase.execute()

        // Assert
        assertEquals(result, mockCategoriesDomain)
    }

    @Test(expected = Exception::class)
    fun `test execute error`() = runTest {
        // Arrange
        val mockError = Exception("Error occurred")
        `when`(favoriteMealRepository.getAllCategories()).thenThrow(mockError)

        // Act
        getAllCategoriesMealUseCase.execute()

        // No need for an assertion here as the test should throw the expected exception.
    }
}