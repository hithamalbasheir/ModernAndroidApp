package com.hitham.modernandroidsample.ui.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hitham.modernandroidsample.ui.viewmodels.MedicineViewModel

@Composable
fun AppNavigator(
	navController: NavHostController,
	viewModel: MedicineViewModel,
) {
	NavHost(
		navController = navController,
		startDestination = Destinations.LOGIN,
		builder = {
			composable(Destinations.LOGIN) {
				LoginScreen(onUserLogged = {
					val route = Destinations.HOME.replace("{username}", it)
					navController.navigate(route)
				})
			}
			composable(Destinations.HOME) { backStackEntry ->
				val username = backStackEntry.arguments?.getString("username")
				if (username != null) {
					HomeScreen(
						username = username,
						viewModel = viewModel,
						onDetailsRequested = {
							navController.navigate(
								Destinations.MEDICINE_DETAIL.replace(
									"{medicineId}", "$it"
								)
							)
						},
					)
				}
			}
			composable(
				route = Destinations.MEDICINE_DETAIL,
				arguments = listOf(
					navArgument("medicineId") {
						type = NavType.IntType
					},
				),
			) { backStackEntry ->
				val medicineId = backStackEntry.arguments?.getInt("medicineId")
				if (medicineId != null) {
					MedicineDetailScreen(
						medicineId = medicineId,
						viewModel = viewModel,
						onBack = {
							navController.popBackStack()
						},
					)
				}
			}
		},
	)
}
