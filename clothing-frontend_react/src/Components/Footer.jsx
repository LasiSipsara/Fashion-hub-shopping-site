import React from 'react'
import { Facebook, Instagram, MailOutline, Phone, Pinterest, Room, Twitter } from "@material-ui/icons"
import styled from "styled-components"
import companyLogo from "../images/logo.png";
import { BrowserRouter as Router, Route,Link } from 'react-router-dom';

const Container = styled.div`
    display: flex;
`;
const Left = styled.div`
    flex: 1;
    display:  flex;
    flex-direction: column;
    padding: 20px;
    margin-left:30px;
`;

const Center = styled.div`
    flex: 1;
    padding: 50px;
    margin-left: 30px;
    margin-top:30px;
`;

const Image = styled.img`
    width: 80%;
    height: auto;
 
`;

const Desc = styled.p`
margin-top: 40px;
margin-bottom:20px;
margin-left:20px;
margin-right:0;

`;

const SocialContainer = styled.div`
    display: flex;
`;

const SocialIcon = styled.h1`
    width: 40px;
    height: 40px;
    border-radius: 50%;
    color: white;
    background-color: #${props=>props.color};
    display: flex;
    align-items: center;
    justify-content: center;
    margin-right: 20px;
    margin-left: 20px;
`;


const Title = styled.h3`
    margin-top: 20px;
    margin-bottom: 30px;
`;

const List = styled.ul`
    margin-left: 30px;
    padding: 0;
    list-style: none;
    flex-wrap: wrap;
`;

const ListItem = styled.li`
    width: 50%;
    margin-bottom: 20px;
`;

const Right = styled.div`
    flex: 1;
    padding: 20px;
    margin-left: 30px;
`;

const ContactItem = styled.div`
    margin-bottom: 20px;
    display: flex;
    align-items: center;
`;



const NavLink = styled(Link)`
  color: black;
  text-decoration: none;
  cursor: pointer;
  &:hover {
    color: #F535AA;
    
  }

`;


const Footer = () => {
  return (
    <Container>
        <Left>
        <Image src={companyLogo}/>
            <Desc>Follow Us On...</Desc>
            <SocialContainer>
                <SocialIcon color="3B5999">
                    <Facebook/>
                </SocialIcon>
                <SocialIcon color="E4405F">
                    <Instagram/>
                </SocialIcon>
                <SocialIcon color="55ACEE">
                    <Twitter/>
                </SocialIcon>
                <SocialIcon color="E60023">
                    <Pinterest/>
                </SocialIcon>
            </SocialContainer>
            
        </Left>
        <Center>
        <List>
                <ListItem><NavLink to="/">Home</NavLink></ListItem>
                <ListItem><NavLink to="../pages/Cart">Cart</NavLink></ListItem>
                <ListItem><NavLink>My Account</NavLink></ListItem>
            </List>
        
            
        </Center>
        <Right>
            <Title>Contact Us</Title>
            <ContactItem>
                <Room style={{marginRight:"10px"}}/>No.17, St.Jone's Avenue, Galle Road, Colombo.
            </ContactItem>
            <ContactItem>
                <Phone style={{marginRight:"10px"}}/>+94 2 847 210
            </ContactItem>
            <ContactItem>
                <MailOutline style={{marginRight:"10px"}}/>info@clairscloset.lk
            </ContactItem>
        </Right>
    </Container>
    
  )
}

export default Footer
