import Copyright from '../components/Copyright'
import Footer from '../components/Footer'
import Navbar from '../components/Navbar'
import Slider from '../components/Slider'
import Categories from '../components/Categories'
import React, { useEffect, useState } from 'react';


function Home(){



  return (
    <div> 
        
        <Navbar />
        <Slider />
        <Categories/>
        <Footer/>
        <Copyright/>
    </div>
  );
}

export default Home
