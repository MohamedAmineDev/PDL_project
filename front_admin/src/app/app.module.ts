import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { AccueilComponent } from './accueil/accueil.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { CategoryComponent } from './category/category.component';
import { ProductComponent } from './product/product.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AddCategoryComponent } from './add-category/add-category.component';
import { UpdateCategoryComponent } from './update-category/update-category.component';
import { ProductsComponent } from './products/products.component';
import { AddProductComponent } from './add-product/add-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { UsersComponent } from './users/users.component';
import { CommandComponent } from './command/command.component';
import { CommandsThatArePayedAndDeliveredComponent } from './commands-that-are-payed-and-delivered/commands-that-are-payed-and-delivered.component';
import { CommandsThatArePayedAndWaitingForDeliveryComponent } from './commands-that-are-payed-and-waiting-for-delivery/commands-that-are-payed-and-waiting-for-delivery.component';
import { CommandsThatAreWaitingForPaymentComponent } from './commands-that-are-waiting-for-payment/commands-that-are-waiting-for-payment.component';
import { CommandDetailsComponent } from './command-details/command-details.component';
import { SuppliesComponent } from './supplies/supplies.component';
import { AddSupplyComponent } from './add-supply/add-supply.component';
import { SupplyDetailsComponent } from './supply-details/supply-details.component';
import { AuthGuard } from './auth/auth.guard';
import { AccountService } from './services/account.service';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    AccueilComponent,
    DashboardComponent,
    LoginComponent,
    CategoryComponent,
    ProductComponent,
    AddCategoryComponent,
    UpdateCategoryComponent,
    ProductsComponent,
    AddProductComponent,
    UpdateProductComponent,
    UsersComponent,
    CommandComponent,
    CommandsThatArePayedAndDeliveredComponent,
    CommandsThatArePayedAndWaitingForDeliveryComponent,
    CommandsThatAreWaitingForPaymentComponent,
    CommandDetailsComponent,
    SuppliesComponent,
    AddSupplyComponent,
    SupplyDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AccountService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
