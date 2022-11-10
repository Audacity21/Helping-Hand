import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { Button, CardActionArea, CardActions } from '@mui/material';
import './Card.css';

export default function CardView(product) {
  return (
    <Card sx={{ maxWidth: 300 }}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="150"
          image={product.image}
          alt={product.name}
        />
        <CardContent>
          <Typography variant="h5" component="div">
            {product.title}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            {product.description}
          </Typography>
          <div className='card-seller'>
            <div>Sold by {product.seller}</div>
            <div>Rs. {product.price}</div>
          </div>
        </CardContent>
      </CardActionArea>
      <CardActions>
        <Button size="small" color="error">
          Delete
        </Button>
      </CardActions>
    </Card>
  );
}