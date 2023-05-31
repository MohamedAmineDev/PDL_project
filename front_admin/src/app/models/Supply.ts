export interface Supply{
    id:any;
    interventionDate:any;
    totalPrice:number;
    supplyProductList:any;
}
export interface SupplyProduct{
    id:any;
    quantity:number;
    supply:any;
    product:any;
}
export interface CommandProduct{
    id:any;
    quantity:number;
    command:any;
    product:any;
}