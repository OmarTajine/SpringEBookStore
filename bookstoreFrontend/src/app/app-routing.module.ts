import { CheckoutComponent } from './checkout/checkout.component';
import { UpdateBookComponent } from './update-book/update-book.component';
import { AddBookComponent } from './add-book/add-book.component';
import { BookComponent } from './book/book.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './index/index.component';

const routes: Routes = [

    { path: '', component: NavbarComponent, children: [
      { path: '', component: IndexComponent },
      { path: 'checkout', component: CheckoutComponent },
    { path:"books",component: BookComponent},
    { path: 'add', component: AddBookComponent},
    { path: 'update/:id', component: UpdateBookComponent}
  ]

  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
