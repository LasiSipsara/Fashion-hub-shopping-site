import React from 'react'
import './activity.css'

// imported icons =============>
import { BsArrowRightShort } from "react-icons/bs";


// imported images =============>
import user1 from '../../../Assets/user 1.jpg'
import user2 from '../../../Assets/user 2.jpg'
import user3 from '../../../Assets/user 3.jpg'
import user4 from '../../../Assets/user 4.jpg'
import user5 from '../../../Assets/user 5.jpg'

const Activity = () => {
  return (
    <div className='activitySection'>
      <div className="heading flex">
        <h1>Resent Activity</h1>
        <button className='btn flex'>
          See All <BsArrowRightShort className='icon'/>
        </button>
      </div>

      <div className="secContainer grid">
        <div className="singleCustomer flex">
          <img src={user1} alt="Customer Image" />
          <div className="customerDetails">
            <span className="name">Ola Martha</span>
            <small>Ordered a new Shirt</small>
          </div>
          <div className="duration">
            2 min ago
          </div>
        </div>

        <div className="singleCustomer flex">
          <img src={user2} alt="Customer Image" />
          <div className="customerDetails">
            <span className="name">Ola Martha</span>
            <small>Ordered a new Frok</small>
          </div>
          <div className="duration">
            2 min ago
          </div>
        </div>

        <div className="singleCustomer flex">
          <img src={user3} alt="Customer Image" />
          <div className="customerDetails">
            <span className="name">Ola Martha</span>
            <small>Ordered a new Skirt</small>
          </div>
          <div className="duration">
            2 min ago
          </div>
        </div>

        <div className="singleCustomer flex">
          <img src={user4} alt="Customer Image" />
          <div className="customerDetails">
            <span className="name">Ola Martha</span>
            <small>Ordered a new T-Shirt</small>
          </div>
          <div className="duration">
            2 min ago
          </div>
        </div>

        <div className="singleCustomer flex">
          <img src={user5} alt="Customer Image" />
          <div className="customerDetails">
            <span className="name">Ola Martha</span>
            <small>Ordered a new Shirt</small>
          </div>
          <div className="duration">
            2 min ago
          </div>
        </div>


      </div>


    </div>
  )
}

export default Activity