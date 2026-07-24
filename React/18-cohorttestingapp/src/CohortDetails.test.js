import React from 'react';
import { render, screen } from '@testing-library/react';
import CohortDetails from './CohortDetails';
import { CohortData } from './Cohort';

describe('Cohort Details Component', () => {
  // Test 1: should create the component
  test('should create the component', () => {
    const { container } = render(<CohortDetails cohort={CohortData[0]} />);
    expect(container).toBeDefined();
  });

  // Test 2: should initialize the props
  test('should initialize the props', () => {
    const testCohort = CohortData[0];
    render(<CohortDetails cohort={testCohort} />);
    expect(screen.getByText(testCohort.name)).toBeInTheDocument();
  });

  // Test 3: should display cohort code in h3
  test('should display cohort code in h3', () => {
    const testCohort = CohortData[0];
    render(<CohortDetails cohort={testCohort} />);
    const h3Element = screen.getByRole('heading', { level: 3 });
    expect(h3Element).toHaveTextContent(testCohort.code);
  });

  // Test 4: should always render same html
  test('should always render same html', () => {
    const { container } = render(<CohortDetails cohort={CohortData[0]} />);
    expect(container.firstChild).toMatchSnapshot();
  });
});
