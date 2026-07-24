import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  const [view, setView] = useState('books');
  const [showNotification, setShowNotification] = useState(true);

  // 1. Element Variable
  let selectedComponent;
  if (view === 'books') {
    selectedComponent = <BookDetails />;
  } else if (view === 'blogs') {
    selectedComponent = <BlogDetails />;
  } else {
    selectedComponent = <CourseDetails />;
  }

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h2>Cognizant Blogger Portal</h2>
      <div style={{ marginBottom: '15px' }}>
        <button onClick={() => setView('books')} style={{ marginRight: '10px' }}>Books</button>
        <button onClick={() => setView('blogs')} style={{ marginRight: '10px' }}>Blogs</button>
        <button onClick={() => setView('courses')} style={{ marginRight: '10px' }}>Courses</button>
      </div>

      {/* Logical && Operator */}
      {showNotification && (
        <div style={{ padding: '10px', backgroundColor: '#d1e7dd', marginBottom: '15px' }}>
          <strong>Notice:</strong> Exploring multiple conditional rendering methods!
        </div>
      )}

      {/* Ternary Operator */}
      <p>Current View Type: <strong>{view === 'books' ? 'Book Section' : 'Other Section'}</strong></p>

      {/* Element Variable Rendering */}
      {selectedComponent}
    </div>
  );
}

export default App;
