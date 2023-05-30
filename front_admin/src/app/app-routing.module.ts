import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AccueilComponent } from './accueil/accueil.component';
import { CategoryComponent } from './category/category.component';
import { ProductsComponent } from './products/products.component';
import { UsersComponent } from './users/users.component';
import { CommandComponent } from './command/command.component';
import { CommandsThatAreWaitingForPaymentComponent } from './commands-that-are-waiting-for-payment/commands-that-are-waiting-for-payment.component';
import { CommandsThatArePayedAndWaitingForDeliveryComponent } from './commands-that-are-payed-and-waiting-for-delivery/commands-that-are-payed-and-waiting-for-delivery.component';
import { CommandsThatArePayedAndDeliveredComponent } from './commands-that-are-payed-and-delivered/commands-that-are-payed-and-delivered.component';
import { CommandDetailsComponent } from './command-details/command-details.component';
import { SuppliesComponent } from './supplies/supplies.component';
import { SupplyDetailsComponent } from './supply-details/supply-details.component';
import { AuthGuard } from './auth/auth.guard';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'home', component: AccueilComponent, canActivate: [AuthGuard] },
  { path: 'manage_categories', component: CategoryComponent, canActivate: [AuthGuard] },
  { path: 'manage_products', component: ProductsComponent, canActivate: [AuthGuard] },
  { path: 'manage_users', component: UsersComponent, canActivate: [AuthGuard] },
  { path: 'manage_commands', component: CommandComponent, canActivate: [AuthGuard] },
  { path: 'manage_waiting_for_payment_commands', component: CommandsThatAreWaitingForPaymentComponent, canActivate: [AuthGuard] },
  { path: 'manage_payed_and_waiting_for_delivery_commands', component: CommandsThatArePayedAndWaitingForDeliveryComponent, canActivate: [AuthGuard] },
  { path: 'manage_payed_and_delivery_commands', component: CommandsThatArePayedAndDeliveredComponent },
  { path: 'command_details/:id', component: CommandDetailsComponent, canActivate: [AuthGuard] },
  { path: 'manage_supplies', component: SuppliesComponent, canActivate: [AuthGuard] },
  { path: 'supply_details/:id', component: SupplyDetailsComponent, canActivate: [AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
