import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {Router, RouterModule, Routes} from "@angular/router";
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { FormsModule} from "@angular/forms";
import { HttpClientModule} from "@angular/common/http";
import { WelcomeComponent } from './welcome/welcome.component';
import { MenuComponent } from './menu/menu.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { SuccessComponent } from './success/success.component';
import { MerchantWelcomeComponent } from './merchant-welcome/merchant-welcome.component';
import { MerchantMenuComponent } from './merchant-menu/merchant-menu.component';
import { AddItemComponent } from './add-item/add-item.component';
import { ContactUsComponent } from './contact-us/contact-us.component';

const appRoutes:Routes=[
  {path:'login',
  component:LoginComponent},
  {path:'register',
  component:RegisterComponent},
  {path:'welcome',
  component:WelcomeComponent},
  {path:'menu',
  component:MenuComponent},
  {path:'home',
  component:HomeComponent},
  {path:'checkout',
  component:CheckoutComponent},
  {path:'success',
  component:SuccessComponent},
  {path:'merchantWelcome',
  component:MerchantWelcomeComponent},
  {path:'merchantMenu',
  component:MerchantMenuComponent},
  {path:'',
  component:HomeComponent},
  {path:'addItem',
  component:AddItemComponent},
  {path:'contactUs',
  component:ContactUsComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    WelcomeComponent,
    MenuComponent,
    CheckoutComponent,
    SuccessComponent,
    MerchantWelcomeComponent,
    MerchantMenuComponent,
    AddItemComponent,
    ContactUsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes,{useHash: true}),
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
