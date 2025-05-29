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
from fastapi import FastAPI, HTTPException
from datetime import datetime
from pymongo import MongoClient

app = FastAPI()

# MongoDB connection
client = MongoClient("mongodb://localhost:27017/")
db = client["your_database_name"]

@app.get("/get_user_time/{user_id}", status_code=200)
async def get_time_detail(user_id: str):
    try:
        collection = db["projectplanning"]
        total_hours = 0
        
        # Find all documents in the collection
        for doc in collection.find():
            resources = doc.get("resources", [])
            
            for resource in resources:
                if resource.get("domain_id") == user_id:
                    # Parse date and check if it's current month
                    date_str = resource.get("date")
                    if date_str:
                        try:
                            input_date = datetime.strptime(date_str, "%Y-%m-%d")
                            now = datetime.now()
                            is_current_month = (input_date.year == now.year) and (input_date.month == now.month)
                            
                            if is_current_month:
                                total_hours += resource.get("hours", 0)
                        except ValueError as e:
                            print(f"Error parsing date {date_str}: {e}")
                            continue
        
        return {"success": True, "data": {"hours": total_hours}}
    
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

*/

/*
import { useState, useRef, useEffect } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { useInView } from 'react-intersection-observer';

const journeyEvents = [
  {
    id: 1,
    date: '2023-01-15',
    title: 'Project Kickoff',
    description: 'Initial meeting with stakeholders to define project scope and objectives.',
    icon: '🏁',
    color: 'bg-blue-500'
  },
  {
    id: 2,
    date: '2023-02-28',
    title: 'Research Phase',
    description: 'Conducted user research and market analysis to identify key opportunities.',
    icon: '🔍',
    color: 'bg-green-500'
  },
  {
    id: 3,
    date: '2023-04-10',
    title: 'Prototype Development',
    description: 'Created interactive prototypes for user testing and feedback.',
    icon: '📱',
    color: 'bg-yellow-500'
  },
  {
    id: 4,
    date: '2023-06-22',
    title: 'User Testing',
    description: 'Conducted usability tests with 20 participants to validate design decisions.',
    icon: '🧪',
    color: 'bg-orange-500'
  },
  {
    id: 5,
    date: '2023-08-05',
    title: 'Development Sprint',
    description: 'Engineering team began implementation of core features.',
    icon: '⚙️',
    color: 'bg-red-500'
  },
  {
    id: 6,
    date: '2023-10-18',
    title: 'Beta Launch',
    description: 'Released product to select group of beta testers for real-world feedback.',
    icon: '🚦',
    color: 'bg-purple-500'
  },
  {
    id: 7,
    date: '2024-01-10',
    title: 'Official Launch',
    description: 'Public release of the product with marketing campaign.',
    icon: '🏆',
    color: 'bg-indigo-500'
  }
];

const formatDate = (dateString) => {
  const options = { year: 'numeric', month: 'short', day: 'numeric' };
  return new Date(dateString).toLocaleDateString('en-US', options);
};

const RoadEvent = ({ event, isLast, expanded, onClick }) => {
  const [ref, inView] = useInView({
    threshold: 0.5,
    triggerOnce: false
  });

  const variants = {
    hidden: { opacity: 0, y: 20 },
    visible: { opacity: 1, y: 0 }
  };

  return (
    <motion.div
      ref={ref}
      initial="hidden"
      animate={inView ? "visible" : "hidden"}
      variants={variants}
      transition={{ duration: 0.5 }}
      className="relative flex flex-col items-center px-4"
    >
      {/* Road marker line */}
      <div className={`absolute h-8 w-1 ${event.color} top-0`}></div>
      
      {/* Road sign post */}
      <div className="absolute h-16 w-1 bg-gray-400 top-8"></div>
      
      {/* Event marker */}
      <div 
        className={`absolute w-10 h-10 rounded-full flex items-center justify-center top-24 z-10 cursor-pointer text-xl ${event.color} text-white border-4 border-white shadow-lg`}
        onClick={onClick}
      >
        {event.icon}
      </div>
      
      {/* Road surface */}
      {!isLast && (
        <div className="absolute h-1 bg-gray-700 top-32 left-1/2 right-0"></div>
      )}
      
      {/* Road markings (dashed line) */}
      {!isLast && (
        <div className="absolute h-1 top-32 left-1/2 right-0 flex">
          {[...Array(10)].map((_, i) => (
            <div key={i} className="w-4 h-1 bg-yellow-400 mr-4"></div>
          ))}
        </div>
      )}
      
      {/* Event card */}
      <div 
        className={`mt-32 p-4 rounded-lg shadow-sm cursor-pointer transition-all duration-300 w-48 ${expanded ? 'bg-white shadow-lg' : 'bg-gray-50'}`}
        onClick={onClick}
      >
        <div className="flex flex-col items-center">
          <h3 className="font-semibold text-center">{event.title}</h3>
          <span className="text-xs text-gray-500 mt-1">{formatDate(event.date)}</span>
        </div>
        
        <AnimatePresence>
          {expanded && (
            <motion.div
              initial={{ opacity: 0, height: 0 }}
              animate={{ opacity: 1, height: 'auto' }}
              exit={{ opacity: 0, height: 0 }}
              transition={{ duration: 0.3 }}
              className="overflow-hidden text-center mt-2 text-xs"
            >
              <p className="text-gray-600">{event.description}</p>
            </motion.div>
          )}
        </AnimatePresence>
      </div>
    </motion.div>
  );
};

const RoadJourney = () => {
  const [expandedEvent, setExpandedEvent] = useState(null);
  const containerRef = useRef(null);

  const handleEventClick = (eventId) => {
    setExpandedEvent(expandedEvent === eventId ? null : eventId);
  };

  useEffect(() => {
    if (expandedEvent && containerRef.current) {
      const element = document.getElementById(`event-${expandedEvent}`);
      if (element) {
        element.scrollIntoView({ behavior: 'smooth', block: 'nearest', inline: 'center' });
      }
    }
  }, [expandedEvent]);

  return (
    <div className="min-h-screen bg-gray-100 py-12 px-4 sm:px-6 lg:px-8">
      <div className="max-w-6xl mx-auto">
        <motion.div
          initial={{ opacity: 0, y: -20 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ duration: 0.5 }}
          className="text-center mb-12"
        >
          <h1 className="text-3xl font-bold text-gray-900 mb-2">Project Roadmap</h1>
          <p className="text-gray-600">Follow the road to see our journey milestones</p>
        </motion.div>

        {/* Road Container */}
        <div 
          ref={containerRef}
          className="bg-white rounded-xl shadow-sm p-6 relative overflow-hidden"
        >
          {/* Road background */}
          <div className="absolute inset-0 bg-gray-200 opacity-10"></div>
          
          {/* Road surface */}
          <div className="absolute h-1 bg-gray-700 top-32 left-0 right-0"></div>
          
          {/* Center dashed line */}
          <div className="absolute h-1 top-32 left-0 right-0 flex">
            {[...Array(30)].map((_, i) => (
              <div key={i} className="w-4 h-1 bg-yellow-400 mr-4"></div>
            ))}
          </div>
          
          {/* Side stripes */}
          <div className="absolute h-1 top-28 left-0 right-0 border-t-2 border-dashed border-gray-400"></div>
          <div className="absolute h-1 top-36 left-0 right-0 border-t-2 border-dashed border-gray-400"></div>

          {/* Events container */}
          <div className="overflow-x-auto pb-12">
            <div className="flex" style={{ minWidth: `${journeyEvents.length * 200}px` }}>
              {journeyEvents.map((event, index) => (
                <div 
                  key={event.id} 
                  id={`event-${event.id}`}
                  className="flex-shrink-0"
                >
                  <RoadEvent
                    event={event}
                    isLast={index === journeyEvents.length - 1}
                    expanded={expandedEvent === event.id}
                    onClick={() => handleEventClick(event.id)}
                  />
                </div>
              ))}
            </div>
          </div>

          {/* Starting line flag */}
          <div className="absolute top-20 left-4 text-4xl">🚩</div>
          
          {/* Finish line flag */}
          <div className="absolute top-20 right-4 text-4xl">🏁</div>
        </div>
      </div>
    </div>
  );
};

export default RoadJourney;
/*
import { ExclamationTriangleIcon } from "@heroicons/react/24/outline";

const UserNotFound = ({ username, onRetry }) => {
  return (
    <div className="flex flex-col items-center justify-center min-h-[60vh] px-4 text-center">
      <div className="bg-red-50 p-6 rounded-full mb-6">
        <ExclamationTriangleIcon className="h-12 w-12 text-red-500" />
      </div>
      
      <h2 className="text-2xl font-bold text-gray-800 mb-2">
        User Not Found
      </h2>
      
      <p className="text-gray-600 mb-6 max-w-md">
        {username ? `We couldn't find any data for "${username}".` : "No user data available."}
        <br />
        Please check the username and try again.
      </p>
      
      <div className="flex gap-4">
        {onRetry && (
          <button
            onClick={onRetry}
            className="px-6 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700 transition-colors"
          >
            Try Again
          </button>
        )}
        <button
          onClick={() => window.history.back()}
          className="px-6 py-2 bg-gray-200 text-gray-800 rounded-lg hover:bg-gray-300 transition-colors"
        >
          Go Back
        </button>
      </div>
      
      <div className="mt-8 text-sm text-gray-500">
        <p>Need help? <a href="#" className="text-blue-600 hover:underline">Contact support</a></p>
      </div>
    </div>
  );
};

export default UserNotFound;




