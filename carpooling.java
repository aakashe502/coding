package Custom_Sorting;
import java.io.*;
import java.util.*;

public class carpooling {
    public static void main(String args[])throws IOException{
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       int n=Integer.parseInt(br.readLine());
       int arr[][]=new int[n][2];
       int i;
       for(i=0;i<n;i++){
        String a[]=br.readLine().split(" ");
        int x=Integer.parseInt(a[0]);
        int y=Integer.parseInt(a[1]);
        arr[i]=new int[]{x,y};
       }
        Arrays.sort(arr,new Comparator<int[]>(){
            public int compare(int a[],int b[]){
                if(a[1]==b[1])
                return a[0]-b[0];
                return a[1]-b[1];
            }
        });
        for(i=0;i<n;i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }
       
    }
    
}

/*

import React from 'react';

const UserJourneyRoadmap = ({ journey }) => {
  return (
    <div className="max-w-4xl mx-auto px-4 py-8">
      <h1 className="text-3xl font-bold text-center mb-8 text-indigo-700">User Journey Roadmap</h1>
      
      <div className="relative">
        {/* Main pathway line */}
        <div className="absolute left-8 top-0 h-full w-2 bg-indigo-300 rounded-full"></div>
        
        <div className="space-y-12 pl-16">
          {journey.map((step, index) => (
            <div key={index} className="relative">
              {/* Step indicator */}
              <div className="absolute -left-14 top-1/2 transform -translate-y-1/2 w-8 h-8 rounded-full bg-indigo-600 border-4 border-white flex items-center justify-center z-10">
                <span className="text-white font-bold">{index + 1}</span>
              </div>
              
              {/* Step card */}
              <div className={`p-6 rounded-lg shadow-md ${index % 2 === 0 ? 'bg-white' : 'bg-indigo-50'} border-l-4 ${getStepColor(index)} relative`}>
                <h3 className="text-xl font-semibold mb-2">{step.title}</h3>
                <p className="text-gray-600 mb-4">{step.description}</p>
                
                {step.actions && step.actions.length > 0 && (
                  <div className="mt-4">
                    <h4 className="text-sm font-medium text-gray-500 mb-2">ACTIONS</h4>
                    <ul className="space-y-2">
                      {step.actions.map((action, actionIndex) => (
                        <li key={actionIndex} className="flex items-start">
                          <span className="text-indigo-500 mr-2">•</span>
                          <span className="text-gray-700">{action}</span>
                        </li>
                      ))}
                    </ul>
                  </div>
                )}
                
                {/* Connector arrow for all steps except last */}
                {index < journey.length - 1 && (
                  <div className={`absolute ${index % 2 === 0 ? 'left-full' : 'right-full'} top-1/2 transform -translate-y-1/2 w-6 h-6`}>
                    <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                      <path d="M9 5L16 12L9 19" stroke="#818CF8" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/>
                    </svg>
                  </div>
                )}
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

// Helper function to get different border colors for variety
const getStepColor = (index) => {
  const colors = [
    'border-indigo-500',
    'border-purple-500',
    'border-blue-500',
    'border-green-500',
    'border-yellow-500',
    'border-red-500',
  ];
  return colors[index % colors.length];
};

export default UserJourneyRoadmap;


import React from 'react';
import UserJourneyRoadmap from './UserJourneyRoadmap';

const App = () => {
  const userJourney = [
    {
      title: 'Awareness',
      description: 'User first discovers your product or service',
      actions: [
        'See social media ad',
        'Read blog post',
        'Word of mouth referral'
      ]
    },
    {
      title: 'Consideration',
      description: 'User evaluates whether your product fits their needs',
      actions: [
        'Visit pricing page',
        'Compare features',
        'Read customer reviews'
      ]
    },
    {
      title: 'Purchase',
      description: 'User makes the decision to buy or subscribe',
      actions: [
        'Add to cart',
        'Complete checkout',
        'Receive confirmation'
      ]
    },
    {
      title: 'Retention',
      description: 'User continues to use and find value in your product',
      actions: [
        'Receive onboarding emails',
        'Use key features',
        'Renew subscription'
      ]
    },
    {
      title: 'Advocacy',
      description: 'User becomes a promoter of your product',
      actions: [
        'Refer friends',
        'Write positive review',
        'Share on social media'
      ]
    }
  ];

  return (
    <div className="min-h-screen bg-gray-50 py-12">
      <UserJourneyRoadmap journey={userJourney} />
    </div>
  );
};

export default App;




