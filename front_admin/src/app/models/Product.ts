export interface FormProduct {
    id: number;
    label: string;
    quantity: any;
    price: any;
    imageLink: string;
    categoryId: any;
}
export class Product {
    public id: any ;
    public label: string = "";
    public quantity: number = 0;
    public price: number = 0;
    public imageLink: string = "";
    public category: any;
    public categoryId:any;
    constructor(id:any,label: string, quantity: number, price: number, imageLink: string, categoryId: any) {
        this.id = id;
        this.label = label;
        this.quantity = quantity;
        this.price = price;
        this.imageLink = imageLink;
        this.category = { id: categoryId }
        this.categoryId=categoryId;
    }

}