import { Book } from './../Models/book';
import { Router } from '@angular/router';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';


@Component({
  selector: 'app-add-cart',
  templateUrl: './add-cart.component.html',
  styleUrls: ['./add-cart.component.css']
})
export class AddCartComponent implements OnInit {
  quantite: number;
  name: string;
  book:Book
  constructor(
    public dialogRef: MatDialogRef<AddCartComponent>,
    @Inject(MAT_DIALOG_DATA) public data:Book ) {
      this.book=data;
    }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }


// methode save b local storage nhot fehe
// localStorage.setItem("cart", {book, qty})
//removeItem("cart")
//getItem("cart")




}
