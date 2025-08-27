import React, { useContext } from 'react'
import { HomeContext } from '../context/HomeContext'
import Item from '../components/Item/Item';
import dropdown_icon from '../components/Assets/dropdown_icon.png'
import './CSS/ShopCategory.css';

 const ShopCategory = (props) => {
  const { all_product } = useContext(HomeContext); 
  return (
    <div className='shop-category'>
      <div className="shopcategory-indexsort">
        <p>
          <span>Showing 1-12 </span> out of 36 products
        </p>
        <div className="shopcategory-sort">
          Sort by <img src={dropdown_icon} alt='' />
        </div>
      </div>
      <div className="shopcategory-products">
        {all_product.map((item,i) => {
          if(props.category === item.category)
          {
            return <Item key={i} id={item.id} name={item.name} new_price={item.new_price} image={item.image} />
          }
          else{
            return null;
          }
        })}
      </div>
      <div className="shopcategory-loadmore">
        Explore More
      </div>
    </div>
  )
}
export default ShopCategory;
