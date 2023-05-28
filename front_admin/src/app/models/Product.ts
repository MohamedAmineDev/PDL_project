export interface FormProduct {
    id: number;
    label: string;
    quantity: number;
    price: number;
    categoryId: any;
    imageLink:string;
}
export class Product {
    public id: any ;
    public label: string = "";
    public quantity: number = 0;
    public price: number = 0;
    public category: any;
    public categoryId:any;
    public imageLink:string;
    constructor(id:any,label: string, quantity: number, price: number, categoryId: any,imageLink:string) {
        this.id = id;
        this.label = label;
        this.quantity = quantity;
        this.price = price;
        this.category = { id: categoryId }
        this.categoryId=categoryId;
        this.imageLink=imageLink;
    }
}