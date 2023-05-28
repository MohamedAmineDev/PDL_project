export interface LoginUser{
    email:string;
    password:string;
}
export interface CurrentUser{
    firstName:string;
    lastName:string;
    email:string;
    role:string;
}
export interface Client{
    id:any;
    email:string;
    nom:string;
    prenom:string;
    unlocked:boolean;
}