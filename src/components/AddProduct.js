import React, { useState } from 'react';
import './AddProduct.css';
import AddProductService from '../services/AddProductService';

function AddProduct() {

const [products, setProducts] = useState({
  title: "",
  image: "",
  price: 0,
  description: "",
  seller: "",
});

const handleChange = (e) => {
  const value = e.target.value;
  setProducts({...products,[e.target.name] : value});
  console.log(products);
}


const convertToBase64 = (file) => {
  return new Promise((resolve, reject) => {
    const fileReader = new FileReader();
    fileReader.readAsDataURL(file);
    fileReader.onload = () => {
      resolve(fileReader.result);
    };
    fileReader.onerror = (error) => {
      reject(error);
    };
  });
};
const handleFileUpload = async (e) => {
  const file = e.target.files[0];
  const base64 = await convertToBase64(file);
  setProducts({ ...products, image: base64 });
};

const saveProduct = (e) => {
  e.preventDefault();
  AddProductService.saveProduct(products)
    .then((response) => {
      alert("User is successfully registered");
      console.log(response);
    })
    .catch((error) => {
      console.log(error.response.data);
    });
};

  return (
    <div className='add-product-container'>
        <form onSubmit={saveProduct} className='add-product-form'>
            <input className='ap-form-input' name='title' value={products.title} type='text' placeholder='title' onChange={(e) => handleChange(e)} />
            <input className='ap-form-input' type='file' name='image' onChange={(e)=>{
              handleFileUpload(e); }} />
            <input className='ap-form-input' type='number' name='price' value={products.price} placeholder='price' onChange={(e) => handleChange(e)} />
            <input className='ap-form-input' type='text' name='description' value={products.description} placeholder='description' onChange={(e) => handleChange(e)}  />
            <input className='ap-form-input' type='text' name='seller' value={products.seller} placeholder='seller' onChange={(e) => handleChange(e)} />
            <button type='submit'>Add Product</button>
        </form>
    </div>
  )
}

export default AddProduct;