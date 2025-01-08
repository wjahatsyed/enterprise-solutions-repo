import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Table, Button } from 'react-bootstrap';

function FragranceList() {
  const [fragrances, setFragrances] = useState([]);

  useEffect(() => {
    axios.get('http://enterprise-solutions-repo-production.up.railway.app/api/v1/fragrances')
      .then(response => setFragrances(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <Table striped bordered hover>
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Brand</th>
          <th>Type</th>
          <th>Description</th>
          <th>Price</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {fragrances.map(f => (
          <tr key={f.id}>
            <td>{f.id}</td>
            <td>{f.name}</td>
            <td>{f.brand}</td>
            <td>{f.type}</td>
            <td>{f.description}</td>
            <td>${f.price}</td>
            <td>
              <Button variant="warning">Edit</Button>{' '}
              <Button variant="danger">Delete</Button>
            </td>
          </tr>
        ))}
      </tbody>
    </Table>
  );
}

export default FragranceList;
