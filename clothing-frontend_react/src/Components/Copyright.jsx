import styled from "styled-components"

const Container = styled.div`
    display: block;
`;

const CopyRightMessage = styled.p`
    font-size: 14px;
    text-align: center;
    margin: 10px 0;
    color: #5e5c5c;
`;

export const Copyright = () => {
  return (
    <Container>
        
           <CopyRightMessage>Copyright @ Clair's Closet| All Rights Reserved. 2024</CopyRightMessage> 
       
    </Container>
  )
}

export default Copyright
